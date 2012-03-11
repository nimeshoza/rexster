package com.tinkerpop.rexster.protocol;

import com.tinkerpop.rexster.Tokens;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.Arrays;
import java.util.List;

public class RexsterScriptEngineFactory implements ScriptEngineFactory {

    private static final String ENGINE_NAME = "rexster";
    private static final String LANGUAGE_NAME = "rexster";
    private static final String VERSION_NUMBER = Tokens.VERSION;
    private static final String PLAIN = "plain";
    private static final List<String> EXTENSIONS = Arrays.asList("rex");

    public String getEngineName() {
        return ENGINE_NAME;
    }

    public String getEngineVersion() {
        return VERSION_NUMBER;
    }

    public List<String> getExtensions() {
        return EXTENSIONS;
    }

    public String getLanguageName() {
        return LANGUAGE_NAME;
    }

    public String getLanguageVersion() {
        return VERSION_NUMBER;
    }

    public String getMethodCallSyntax(final String obj, final String m, final String... args) {
        return null;
    }

    public List<String> getMimeTypes() {
        return Arrays.asList(PLAIN);
    }

    public List<String> getNames() {
        return Arrays.asList(LANGUAGE_NAME);
    }

    public String getOutputStatement(final String toDisplay) {
        return null;
    }

    public Object getParameter(final String key) {
        if (key.equals(ScriptEngine.ENGINE)) {
            return this.getEngineName();
        } else if (key.equals(ScriptEngine.ENGINE_VERSION)) {
            return this.getEngineVersion();
        } else if (key.equals(ScriptEngine.NAME)) {
            return ENGINE_NAME;
        } else if (key.equals(ScriptEngine.LANGUAGE)) {
            return this.getLanguageName();
        } else if (key.equals(ScriptEngine.LANGUAGE_VERSION)) {
            return this.getLanguageVersion();
        } else
            return null;
    }

    public String getProgram(final String... statements) {
        String program = "";

        for (String statement : statements) {
            program = program + statement + "\n";
        }

        return program;
    }

    public ScriptEngine getScriptEngine() {
        return new RexsterScriptEngine();
    }
}
