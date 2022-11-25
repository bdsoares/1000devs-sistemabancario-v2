package br.com.mesttra.sb.exceptions;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(String message) {
        super(message);
    }
}