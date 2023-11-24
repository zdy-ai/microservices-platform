package com.erp.tms.aliexpress.util.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author zdy
 * @ClassName JSONReader
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public abstract class JSONReader {
    private static final Object OBJECT_END = new Object();

    private static final Object ARRAY_END = new Object();

    private static final Object COLON = new Object();

    private static final Object COMMA = new Object();

    public static final int FIRST = 0;

    public static final int CURRENT = 1;

    public static final int NEXT = 2;

    private static Map<Character, Character> escapes = new HashMap<Character, Character>();

    private CharacterIterator it;

    private char c;

    private Object token;

    static {
        escapes.put(Character.valueOf('"'), Character.valueOf('"'));
        escapes.put(Character.valueOf('\\'), Character.valueOf('\\'));
        escapes.put(Character.valueOf('/'), Character.valueOf('/'));
        escapes.put(Character.valueOf('b'), Character.valueOf('\b'));
        escapes.put(Character.valueOf('f'), Character.valueOf('\f'));
        escapes.put(Character.valueOf('n'), Character.valueOf('\n'));
        escapes.put(Character.valueOf('r'), Character.valueOf('\r'));
        escapes.put(Character.valueOf('t'), Character.valueOf('\t'));
    }

    private StringBuffer buf = new StringBuffer();

    private char next() {
        this.c = this.it.next();
        return this.c;
    }

    private void skipWhiteSpace() {
        while (Character.isWhitespace(this.c))
            next();
    }

    public Object read(CharacterIterator ci, int start) {
        this.it = ci;
        switch (start) {
            case 0:
                this.c = this.it.first();
                break;
            case 1:
                this.c = this.it.current();
                break;
            case 2:
                this.c = this.it.next();
                break;
        }
        return read();
    }

    public Object read(CharacterIterator it) {
        return read(it, 2);
    }

    public Object read(String string) {
        return read(new StringCharacterIterator(string), 0);
    }

    private Object read() {
        skipWhiteSpace();
        char ch = this.c;
        next();
        switch (ch) {
            case '"':
                this.token = string();
                return this.token;
            case '[':
                this.token = array();
                return this.token;
            case ']':
                this.token = ARRAY_END;
                return this.token;
            case ',':
                this.token = COMMA;
                return this.token;
            case '{':
                this.token = object();
                return this.token;
            case '}':
                this.token = OBJECT_END;
                return this.token;
            case ':':
                this.token = COLON;
                return this.token;
            case 't':
                next();
                next();
                next();
                this.token = Boolean.TRUE;
                return this.token;
            case 'f':
                next();
                next();
                next();
                next();
                this.token = Boolean.FALSE;
                return this.token;
            case 'n':
                next();
                next();
                next();
                this.token = null;
                return this.token;
        }
        this.c = this.it.previous();
        if (Character.isDigit(this.c) || this.c == '-')
            this.token = number();
        return this.token;
    }

    private Object object() {
        Map<Object, Object> ret = new HashMap<Object, Object>();
        Object key = read();
        while (this.token != OBJECT_END) {
            read();
            if (this.token != OBJECT_END) {
                ret.put(key, read());
                if (read() == COMMA)
                    key = read();
            }
        }
        return ret;
    }

    private Object array() {
        List<Object> ret = new ArrayList();
        Object value = read();
        while (this.token != ARRAY_END) {
            ret.add(value);
            if (read() == COMMA)
                value = read();
        }
        return ret;
    }

    private Object number() {
        int length = 0;
        boolean isFloatingPoint = false;
        this.buf.setLength(0);
        if (this.c == '-')
            add();
        length += addDigits();
        if (this.c == '.') {
            add();
            length += addDigits();
            isFloatingPoint = true;
        }
        if (this.c == 'e' || this.c == 'E') {
            add();
            if (this.c == '+' || this.c == '-')
                add();
            addDigits();
            isFloatingPoint = true;
        }
        String s = this.buf.toString();
        return isFloatingPoint ? ((length < 17) ? Double.valueOf(s) : new BigDecimal(s)) : ((length < 19) ? Long.valueOf(s) : new BigInteger(s));
    }

    private int addDigits() {
        int ret;
        for (ret = 0; Character.isDigit(this.c); ret++)
            add();
        return ret;
    }

    private Object string() {
        this.buf.setLength(0);
        while (this.c != '"') {
            if (this.c == '\\') {
                next();
                if (this.c == 'u') {
                    add(unicode());
                    continue;
                }
                Object value = escapes.get(Character.valueOf(this.c));
                if (value != null)
                    add(((Character)value).charValue());
                continue;
            }
            add();
        }
        next();
        return this.buf.toString();
    }

    private void add(char cc) {
        this.buf.append(cc);
        next();
    }

    private void add() {
        add(this.c);
    }

    private char unicode() {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            switch (next()) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    value = (value << 4) + this.c - 48;
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    value = (value << 4) + this.c - 107;
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    value = (value << 4) + this.c - 75;
                    break;
            }
        }
        return (char)value;
    }
}
