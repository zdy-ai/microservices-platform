package com.erp.tms.aliexpress.util.json;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @author zdy
 * @ClassName JSONValidator
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class JSONValidator {
    private JSONErrorListener listener;

    private CharacterIterator it;

    private char c;

    private int col;

    public JSONValidator(JSONErrorListener listener) {
        this.listener = listener;
    }

    public boolean validate(String input) {
        input = input.trim();
        this.listener.start(input);
        boolean ret = valid(input);
        this.listener.end();
        return ret;
    }

    private boolean valid(String input) {
        if ("".equals(input))
            return true;
        boolean ret = true;
        this.it = new StringCharacterIterator(input);
        this.c = this.it.first();
        this.col = 1;
        if (!value()) {
            ret = error("value", 1);
        } else {
            skipWhiteSpace();
            if (this.c != Character.MAX_VALUE)
                ret = error("end", this.col);
        }
        return ret;
    }

    private boolean value() {
        return (literal("true") || literal("false") || literal("null") || string() || number() || object() || array());
    }

    private boolean literal(String text) {
        CharacterIterator ci = new StringCharacterIterator(text);
        char t = ci.first();
        if (this.c != t)
            return false;
        int start = this.col;
        boolean ret = true;
        for (t = ci.next(); t != Character.MAX_VALUE; t = ci.next()) {
            if (t != nextCharacter()) {
                ret = false;
                break;
            }
        }
        nextCharacter();
        if (!ret)
            error("literal " + text, start);
        return ret;
    }

    private boolean array() {
        return aggregate('[', ']', false);
    }

    private boolean object() {
        return aggregate('{', '}', true);
    }

    private boolean aggregate(char entryCharacter, char exitCharacter, boolean prefix) {
        if (this.c != entryCharacter)
            return false;
        nextCharacter();
        skipWhiteSpace();
        if (this.c == exitCharacter) {
            nextCharacter();
            return true;
        }
        while (true) {
            if (prefix) {
                int start = this.col;
                if (!string())
                    return error("string", start);
                skipWhiteSpace();
                if (this.c != ':')
                    return error("colon", this.col);
                nextCharacter();
                skipWhiteSpace();
            }
            if (value()) {
                skipWhiteSpace();
                if (this.c == ',') {
                    nextCharacter();
                } else {
                    if (this.c == exitCharacter)
                        break;
                    return error("comma or " + exitCharacter, this.col);
                }
            } else {
                return error("value", this.col);
            }
            skipWhiteSpace();
        }
        nextCharacter();
        return true;
    }

    private boolean number() {
        if (!Character.isDigit(this.c) && this.c != '-')
            return false;
        int start = this.col;
        if (this.c == '-')
            nextCharacter();
        if (this.c == '0') {
            nextCharacter();
        } else if (Character.isDigit(this.c)) {
            for (; Character.isDigit(this.c); nextCharacter());
        } else {
            return error("number", start);
        }
        if (this.c == '.') {
            nextCharacter();
            if (Character.isDigit(this.c)) {
                for (; Character.isDigit(this.c); nextCharacter());
            } else {
                return error("number", start);
            }
        }
        if (this.c == 'e' || this.c == 'E') {
            nextCharacter();
            if (this.c == '+' || this.c == '-')
                nextCharacter();
            if (Character.isDigit(this.c)) {
                for (; Character.isDigit(this.c); nextCharacter());
            } else {
                return error("number", start);
            }
        }
        return true;
    }

    private boolean string() {
        if (this.c != '"')
            return false;
        int start = this.col;
        boolean escaped = false;
        nextCharacter();
        for (; this.c != Character.MAX_VALUE; nextCharacter()) {
            if (!escaped && this.c == '\\') {
                escaped = true;
            } else if (escaped) {
                if (!escape())
                    return false;
                escaped = false;
            } else if (this.c == '"') {
                nextCharacter();
                return true;
            }
        }
        return error("quoted string", start);
    }

    private boolean escape() {
        int start = this.col - 1;
        if ("\\\"/bfnrtu".indexOf(this.c) < 0)
            return error("escape sequence \\\",\\\\,\\/,\\b,\\f,\\n,\\r,\\t or \\uxxxx", start);
        if (this.c == 'u' && (
                !ishex(nextCharacter()) || !ishex(nextCharacter()) || !ishex(nextCharacter()) || !ishex(nextCharacter())))
            return error("unicode escape sequence \\uxxxx", start);
        return true;
    }

    private boolean ishex(char d) {
        return ("0123456789abcdefABCDEF".indexOf(this.c) >= 0);
    }

    private char nextCharacter() {
        this.c = this.it.next();
        this.col++;
        return this.c;
    }

    private void skipWhiteSpace() {
        while (Character.isWhitespace(this.c))
            nextCharacter();
    }

    private boolean error(String type, int col) {
        if (this.listener != null)
            this.listener.error(type, col);
        return false;
    }
}
