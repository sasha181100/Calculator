import token.Token;
import visitor.CalcVisitor;
import visitor.ParserVisitor;
import visitor.PrintVisitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Tokenizer tokenizer = new Tokenizer(System.in);

        List<Token> tokens = tokenizer.allTokens();
        tokens.forEach(t -> System.out.print(t + " "));
        System.out.println();

        ParserVisitor parserVisitor = new ParserVisitor();
        for (Token token : tokens) {
            token.accept(parserVisitor);
        }
        parserVisitor.finish();
        List<Token> polish = parserVisitor.getResult();

        System.out.println("Polish");
        PrintVisitor printVisitor = new PrintVisitor(System.out);
        for (Token token : polish) {
            token.accept(printVisitor);
            System.out.print(" ");
        }
        System.out.println();

        CalcVisitor calcVisitor = new CalcVisitor();
        for (Token token : polish) {
            token.accept(calcVisitor);
        }
        System.out.println("Result: " + calcVisitor.getResult());
    }
}