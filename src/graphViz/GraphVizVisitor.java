package graphViz;

import ast.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class GraphVizVisitor implements AstVisitor<String> {

        private int state;
        private String nodeBuffer;
        private String linkBuffer;

        public GraphVizVisitor(){
            this.state = 0;
            this.nodeBuffer = "digraph \"ast\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
            this.linkBuffer = "\n";
        }

        public void dumpGraph(String filepath) throws IOException{

            FileOutputStream output = new FileOutputStream(filepath);

            String buffer = this.nodeBuffer + this.linkBuffer + "}";
            byte[] strToBytes = buffer.getBytes();

            output.write(strToBytes);

            output.close();

        }


        private String nextState(){
            int returnedState = this.state;
            this.state++;
            return "N"+ returnedState;
        }

        private void addTransition(String from,String dest){
            this.linkBuffer += String.format("\t%s -> %s; \n", from,dest);

        }

        private void addNode(String node,String label){
            this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node,label);

        }

        @Override
        public String visit(Program program){
            String nodeIdentifier = this.nextState();

            String instructionsState = program.expression.accept(this);

            this.addNode(nodeIdentifier, "Program");
            this.addTransition(nodeIdentifier, instructionsState);

            return nodeIdentifier;
        }

        @Override
        public String visit(Affectsubscript affectsubscript){
            String nodeIdentifier = this.nextState();

            String lavalue = affectsubscript.LaValue.accept(this);
            String expression = affectsubscript.expression.accept(this);

            this.addNode(nodeIdentifier, "lValue subscript");
            this.addTransition(nodeIdentifier, lavalue);
            this.addTransition(nodeIdentifier, expression);

            return nodeIdentifier;
        }

        @Override
        public String visit(Affectfield affectfield){
            String nodeIdentifier = this.nextState();

            String lavalue = affectfield.laValue.accept(this);
            String idf = affectfield.Identifiant.accept(this);

            this.addNode(nodeIdentifier, "lValue field");
            this.addTransition(nodeIdentifier, lavalue);
            this.addTransition(nodeIdentifier, idf);

            return nodeIdentifier;
        }

        @Override
        public String visit(Assign assign){
            String nodeIdentifier = this.nextState();

            String lavalue = assign.LaValue.accept(this);
            String ouexpression = assign.ouexpression.accept(this);

            this.addNode(nodeIdentifier, ":=");
            this.addTransition(nodeIdentifier, lavalue);
            this.addTransition(nodeIdentifier, ouexpression);

            return nodeIdentifier;
        }

        @Override
        public String visit(OuExpr ouExpr){
            String nodeIdentifier = this.nextState();

            String left = ouExpr.left.accept(this);
            String right = ouExpr.right.accept(this);

            this.addNode(nodeIdentifier, "ou");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(EtExpr etExpr){
            String nodeIdentifier = this.nextState();

            String left = etExpr.left.accept(this);
            String right = etExpr.right.accept(this);

            this.addNode(nodeIdentifier, "et");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(Inferieur inferieur){
            String nodeIdentifier = this.nextState();

            String left = inferieur.plusoumoins1.accept(this);
            String right = inferieur.plusoumoins2.accept(this);

            this.addNode(nodeIdentifier, "<");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(Superieur superieur){
            String nodeIdentifier = this.nextState();

            String left = superieur.plusoumoins1.accept(this);
            String right = superieur.plusoumoins2.accept(this);

            this.addNode(nodeIdentifier, ">");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(Superieuregal superieuregal){
            String nodeIdentifier = this.nextState();

            String left = superieuregal.plusoumoins1.accept(this);
            String right = superieuregal.plusoumoins2.accept(this);

            this.addNode(nodeIdentifier, ">=");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(Inferieuregal inferieuregal){
            String nodeIdentifier = this.nextState();

            String left = inferieuregal.plusoumoins1.accept(this);
            String right = inferieuregal.plusoumoins2.accept(this);

            this.addNode(nodeIdentifier, "<=");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(egal egal){
            String nodeIdentifier = this.nextState();

            String left = egal.plusoumoins1.accept(this);
            String right = egal.plusoumoins2.accept(this);

            this.addNode(nodeIdentifier, "=");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(crochetcrochet crochetcrochet){
            String nodeIdentifier = this.nextState();

            String left = crochetcrochet.plusoumoins1.accept(this);
            String right = crochetcrochet.plusoumoins2.accept(this);

            this.addNode(nodeIdentifier, "<>");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(MinusExpr minusExpr){
            String nodeIdentifier = this.nextState();

            String left = minusExpr.left.accept(this);
            String right = minusExpr.right.accept(this);

            this.addNode(nodeIdentifier, "-");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(PlusmoinsExpr plusmoinsExpr){
            String nodeIdentifier = this.nextState();

            String left = plusmoinsExpr.left.accept(this);
            String right = plusmoinsExpr.right.accept(this);

            this.addNode(nodeIdentifier, "+");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(Mult mult){
            String nodeIdentifier = this.nextState();

            String left = mult.left.accept(this);
            String right = mult.right.accept(this);

            this.addNode(nodeIdentifier, "*");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(Divide divide){
            String nodeIdentifier = this.nextState();

            String left = divide.left.accept(this);
            String right = divide.right.accept(this);

            this.addNode(nodeIdentifier, "/");
            this.addTransition(nodeIdentifier, left);
            this.addTransition(nodeIdentifier, right);

            return nodeIdentifier;
        }

        @Override
        public String visit(NegExpr negExpr){
            String nodeIdentifier = this.nextState();

            String left = negExpr.negexpr.accept(this);

            this.addNode(nodeIdentifier, "-");
            this.addTransition(nodeIdentifier, left);

            return nodeIdentifier;
        }



        @Override
        public String visit(Parentheseexpr parentheseexpr){
            String nodeIdentifier = this.nextState();

            String lefto = parentheseexpr.left.accept(this);
            this.addNode(nodeIdentifier,"liste expressions");
            this.addTransition(nodeIdentifier,lefto);
            for(Ast ast:parentheseexpr.listexpr){
                String astState = ast.accept(this);
                this.addTransition(nodeIdentifier,astState);
            }
            return nodeIdentifier;
        }






        /* ma frontiere */


    @Override
    public String visit(Parenthese fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "( )");
        return nodeIdentifier;
    }

    @Override
    public String visit(Nil fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "NIL");
        return nodeIdentifier;


    }

    @Override
    public String visit(Break fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "BREAK");
        return nodeIdentifier;
    }


    @Override
    public String visit(Callexprexpr fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "CALL EXPR");

        String instructionsState =fun.Identifiant.accept(this);
        this.addTransition(nodeIdentifier,instructionsState);
        String instructionsState2 =fun.expression1.accept(this);
        this.addTransition(nodeIdentifier,instructionsState2);
        for(Ast ast:fun.Lexpression){
            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier,astState);
        }

        return nodeIdentifier;
    }

    @Override
    public String visit(Callexpr fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "CALL EXPR");
        String instructionsState =fun.IDF.accept(this);
        this.addTransition(nodeIdentifier,instructionsState);
        return nodeIdentifier;
    }

    @Override
    public String visit(ArrCreate fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "CREATE ARRAY");

        String instructionsState =fun.Identifiant.accept(this);
        this.addTransition(nodeIdentifier,instructionsState);
        String instructionsState2 =fun.expression1.accept(this);
        this.addTransition(nodeIdentifier,instructionsState2);
        String instructionsState3 =fun.expression2.accept(this);
        this.addTransition(nodeIdentifier,instructionsState3);

        return nodeIdentifier;


    }


    @Override
    public String visit(Reccreatefield fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "CREATE REC FIELD");

        String instructionsState =fun.Identifiant.accept(this);
        this.addTransition(nodeIdentifier,instructionsState);
        String instructionsState2 =fun.expression1.accept(this);
        this.addTransition(nodeIdentifier,instructionsState2);
        for(Ast ast:fun.Lexpression){
            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier,astState);
        }
        return nodeIdentifier;


    }

        @Override
        public String visit(Reccreate fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, "CREATE REC");
            String instructionsState =fun.IDF.accept(this);
            this.addTransition(nodeIdentifier,instructionsState);
            return nodeIdentifier;
        }

        @Override
        public String visit(FieldCreate fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "CREATE FIELD");
        String instructionsState =fun.identifiant.accept(this);
        this.addTransition(nodeIdentifier,instructionsState);
        String instructionsState2 =fun.expression.accept(this);
        this.addTransition(nodeIdentifier,instructionsState2);
        return nodeIdentifier;


    }


        @Override
        public String visit(Ifthen fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, "IF THEN");
            String instructionsState =fun.expression1.accept(this);
            this.addTransition(nodeIdentifier,instructionsState);
            String instructionsState2 =fun.expression2.accept(this);
            this.addTransition(nodeIdentifier,instructionsState2);
            return nodeIdentifier;


        }


        @Override
        public String visit(Ifthenelse fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, "IF THEN ELSE");
            String instructionsState =fun.expression1.accept(this);
            this.addTransition(nodeIdentifier,instructionsState);
            String instructionsState2 =fun.expression2.accept(this);
            this.addTransition(nodeIdentifier,instructionsState2);
            String instructionsState3 =fun.expression3.accept(this);
            this.addTransition(nodeIdentifier,instructionsState3);
            return nodeIdentifier;


        }

        @Override
        public String visit(WhileExpr fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, "WHILE");
            String instructionsState =fun.exprwhile.accept(this);
            this.addTransition(nodeIdentifier,instructionsState);
            String instructionsState2 =fun.exprdo.accept(this);
            this.addTransition(nodeIdentifier,instructionsState2);

            return nodeIdentifier;


        }

        @Override
        public String visit(ForExpr fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, "FOR");
            String instructionsState =fun.identifiant.accept(this);
            this.addTransition(nodeIdentifier,instructionsState);
            String instructionsState2 =fun.expression1.accept(this);
            this.addTransition(nodeIdentifier,instructionsState2);
            String instructionsState3 =fun.expression2.accept(this);
            this.addTransition(nodeIdentifier,instructionsState3);
            String instructionsState4 =fun.expression3.accept(this);
            this.addTransition(nodeIdentifier,instructionsState4);
            return nodeIdentifier;


        }
        @Override
        public String visit(Letexprexpr fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, "LET IN");
            for(Ast ast:fun.Ldec){
                String astState = ast.accept(this);
                this.addTransition(nodeIdentifier,astState);
            }
            String instructionsState =fun.expression.accept(this);
            this.addTransition(nodeIdentifier,instructionsState);
            for(Ast ast:fun.Lexpression){
                String astState = ast.accept(this);
                this.addTransition(nodeIdentifier,astState);
            }
            return nodeIdentifier;


        }


    @Override
    public String visit(Letexpr fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "LET IN");
        for(Ast ast:fun.Ldec){
            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier,astState);

        }
        return nodeIdentifier;


    }

        @Override
        public String visit(Tyidf fun){

            String nodeIdentifier = this.nextState();

            String instructionsState =fun.left.accept(this);
            String instructionsState2 =fun.right.accept(this);


            this.addNode(nodeIdentifier, "TYPE IDF");
            this.addTransition(nodeIdentifier, instructionsState);
            this.addTransition(nodeIdentifier, instructionsState2);



            return nodeIdentifier;


        }

    @Override
    public String visit(Tyarr fun){

        String nodeIdentifier = this.nextState();

        String instructionsState =fun.left.accept(this);
        String instructionsState2 =fun.right.accept(this);


        this.addNode(nodeIdentifier, "TYPE ARRAY");
        this.addTransition(nodeIdentifier, instructionsState);
        this.addTransition(nodeIdentifier, instructionsState2);



        return nodeIdentifier;


    }

    @Override
    public String visit(Rectyfield fun){

        String nodeIdentifier = this.nextState();

        String instructionsState =fun.identifiant.accept(this);
        String instructionsState2 =fun.fieldeclaration.accept(this);


        this.addNode(nodeIdentifier, "TYPE RECORD");
        this.addTransition(nodeIdentifier, instructionsState);
        this.addTransition(nodeIdentifier, instructionsState2);


        for(Ast ast:fun.Lfunfield){
            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier,astState);

        }
        return nodeIdentifier;


    }



        @Override
        public String visit(Recty fun){

            String nodeIdentifier = this.nextState();

            String instructionsState =fun.IDF.accept(this);

            this.addNode(nodeIdentifier, "TYPE RECORD");
            this.addTransition(nodeIdentifier, instructionsState);

            return nodeIdentifier;


        }

        @Override
        public String visit(FieldDec fun){

            String nodeIdentifier = this.nextState();

            String instructionsState =fun.identifiant1.accept(this);
            String instructionsState2 =fun.identifiant2.accept(this);


            this.addNode(nodeIdentifier, "FIELD_DEC");
            this.addTransition(nodeIdentifier, instructionsState);
            this.addTransition(nodeIdentifier, instructionsState2);

            return nodeIdentifier;


        }


        @Override
        public String visit(Vartyid fun){

            String nodeIdentifier = this.nextState();

            String instructionsState =fun.left.accept(this);
            String instrcutionsState12 = fun.middle.accept(this);
            String instructionsState2 =fun.right.accept(this);



            this.addNode(nodeIdentifier, "VAR ID");
            this.addTransition(nodeIdentifier, instructionsState);
            this.addTransition(nodeIdentifier,instrcutionsState12);
            this.addTransition(nodeIdentifier, instructionsState2);

            return nodeIdentifier;


        }

@Override
    public String visit(Var fun){

        String nodeIdentifier = this.nextState();

        String instructionsState =fun.idf.accept(this);
        String instructionsState2 =fun.expr.accept(this);


        this.addNode(nodeIdentifier, "VAR");
        this.addTransition(nodeIdentifier, instructionsState);
        this.addTransition(nodeIdentifier, instructionsState2);

        return nodeIdentifier;


    }
    @Override
    public String visit(Funfieldtyid fun){

        String nodeIdentifier = this.nextState();

        String instructionsState =fun.identifiant1.accept(this);
        String instructionsState2 =fun.fieldeclaration1.accept(this);



        this.addNode(nodeIdentifier, "FONCTION FIELDDEC IDF");
        this.addTransition(nodeIdentifier, instructionsState);
        this.addTransition(nodeIdentifier, instructionsState2);


        for(Ast ast:fun.Lfieldeclaration){
            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier,astState);

        }

        String instructionState3=fun.identifiant2.accept(this);
        String instructionsState4 =fun.expression.accept(this);
        this.addTransition(nodeIdentifier, instructionState3);
        this.addTransition(nodeIdentifier, instructionsState4);
        return nodeIdentifier;


    }
@Override
        public String visit(Funfield fun){

            String nodeIdentifier = this.nextState();

            String instructionsState =fun.identifiant.accept(this);
            String instructionsState2 =fun.fieldeclaration.accept(this);


            this.addNode(nodeIdentifier, "FONCTION FIELDDEC");
            this.addTransition(nodeIdentifier, instructionsState);
            this.addTransition(nodeIdentifier, instructionsState2);


            for(Ast ast:fun.Lfunfield){
                String astState = ast.accept(this);
                this.addTransition(nodeIdentifier,astState);

            }

        String instructionsState4 =fun.expression.accept(this);


        this.addTransition(nodeIdentifier, instructionsState4);
            return nodeIdentifier;


        }


@Override
        public String visit(Fun fun){

            String nodeIdentifier = this.nextState();

            String instructionsState =fun.identifiant.accept(this);
            String instructionsState2 =fun.expression.accept(this);

            this.addNode(nodeIdentifier, "FONCTION");
            this.addTransition(nodeIdentifier, instructionsState);
            this.addTransition(nodeIdentifier, instructionsState2);

            return nodeIdentifier;


        }
@Override
        public String visit(Funtyid fun){

        String nodeIdentifier = this.nextState();

        String instructionsState =fun.identifiant1.accept(this);
        String instructionsState2 =fun.identifiant2.accept(this);
        String instructionState3=fun.expression.accept(this);


        this.addNode(nodeIdentifier, "FONCTION IDF");
        this.addTransition(nodeIdentifier, instructionsState);
        this.addTransition(nodeIdentifier, instructionsState2);
        this.addTransition(nodeIdentifier, instructionState3);

            return nodeIdentifier;
        }

        @Override
        public String visit(IDF fun){

            String nodeIdentifier = this.nextState();
            this.addNode(nodeIdentifier, fun.name);
            return nodeIdentifier;
        }

    @Override
    public String visit(INT fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, fun.value);
        return nodeIdentifier;
    }


    @Override
    public String visit(Strings fun){

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, fun.name);
        return nodeIdentifier;
    }


    }






