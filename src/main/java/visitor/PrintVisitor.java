package visitor;

import token.Number;
import token.Brace;
import token.Operation;
import token.Token;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PrintVisitor implements TokenVisitor {
    private final OutputStream stream;

    public PrintVisitor(OutputStream stream) {
        this.stream = stream;
    }

    private void write(Token token) {
        try {
            stream.write(token.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Error while printing output");
        }
    }

    @Override
    public void visit(Number token) {
        write(token);
    }

    @Override
    public void visit(Brace token) {
        write(token);
    }

    @Override
    public void visit(Operation token) {
        write(token);
    }
}