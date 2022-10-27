package utils;


public abstract class Expr {

    // visitors for expressions
    public interface Visitor<T> {
        T visitNumberExpr(Number expr);
        T visitBinopExpr(Binop expr);
    }

    // Nested Expr classes here

    // Number expression
    public static class Number extends Expr {
        public Number(String value){
            this.value = value;
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visitNumberExpr(this);
        }

        public final String value;
    }

    // Binop expression
    public static class Binop extends Expr {
        public Binop(Expr left, Expr right, Token operator) {
            this.left = left;
            this.right = right;
            this.operator = operator;
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visitBinopExpr(this);
        }

        public final Expr left;
        public final Expr right;
        public final Token operator;
    }

    public abstract <T> T accept(Visitor<T> visitor);
}