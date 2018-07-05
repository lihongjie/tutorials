package com.github.lihongjie.core.base.lang;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lihongjie.core.base.util.Assert;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public final class JSON {


    private static final ObjectMapper mapper = new ObjectMapper();

    private final String jsonString;

    private JSON(String jsonString) {
        this.jsonString = jsonString;
    }

    /**
     * Creates a <code>JSON</code> instance from an <code>InputStream</code>.
     * The method assumes the character set is UTF-8.
     *
     * @param inStream
     * @return a <code>JSON</code> instance
     * @throws IOException
     */
    public static JSON from(InputStream inStream) throws IOException {
        Assert.notNull("inStream", inStream);
        String jsonString = IOUtils.toString(inStream, "UTF-8");
        return from(jsonString);
    }

    /**
     * Creates a <code>JSON</code> instance from an unknown data type.
     *
     * @param object
     * @return a <code>JSON</code> instance
     * @throws IOException
     */
    public static JSON from(Object object) throws IOException {
        Assert.notNull("object", object);
        try {
            return from(mapper.writeValueAsString(object));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * Creates a <code>JSON</code> instance from a <code>Reader</code>.
     *
     * @param reader
     * @return a <code>JSON</code> instance
     * @throws IOException
     */
    public static JSON from(Reader reader) throws IOException {
        Assert.notNull("reader", reader);
        String jsonString = IOUtils.toString(reader);
        return from(jsonString);
    }

    /**
     * Creates a <code>JSON</code> instance from a <code>String</code>.
     *
     * @param jsonString
     * @return a <code>JSON</code> instance
     */
    public static JSON from(String jsonString) {
        Assert.notNull("jsonString", jsonString);
        return new JSON(jsonString);
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof JSON) {
            return jsonString.equals(((JSON)obj).jsonString);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return jsonString.hashCode();
    }

    /**
     * Converts this <code>JSON</code> object to the specified type.
     *
     * @param targetClass
     * @return an object of the specified type
     * @throws IOException
     */
    public <T> T toObject(Class<T> targetClass) throws IOException {
        Assert.notNull("targetClass", targetClass);
        try {
            return mapper.readValue(jsonString, targetClass);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @Override
    public String toString() {
        return jsonString;
    }

}
