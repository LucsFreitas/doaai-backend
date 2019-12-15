package br.unicap.doaai.doaai.services;

public class UtilidadesServices {
    public static boolean isEmpty (Object obj) {
        return obj == null || (obj instanceof String && ((String) obj).isEmpty());
    }
}
