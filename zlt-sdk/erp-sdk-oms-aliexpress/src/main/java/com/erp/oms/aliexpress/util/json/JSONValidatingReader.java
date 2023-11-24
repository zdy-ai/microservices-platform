package com.erp.oms.aliexpress.util.json;

/**
 * @author zdy
 * @ClassName JSONValidatingReader
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class JSONValidatingReader extends JSONReader{
    public static final Object INVALID = new Object();

    private JSONValidator validator;

    public JSONValidatingReader(JSONValidator validator) {
        this.validator = validator;
    }

    public JSONValidatingReader(JSONErrorListener listener) {
        this(new JSONValidator(listener));
    }

    public JSONValidatingReader() {
        this(new StdoutStreamErrorListener());
    }

    public Object read(String string) {
        if (!this.validator.validate(string))
            return INVALID;
        return super.read(string);
    }
}
