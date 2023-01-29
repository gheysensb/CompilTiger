package ast;

import error.ErrorFlag;
import tds.TDS;

    public class Assign extends Ast {
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visit(this);
        }

        public Ast LaValue;
        public Ast ouexpression;

        public Assign(Ast LaValue, Ast ouexpression, int line) {
            super(line);
            this.LaValue = LaValue;
            this.ouexpression = ouexpression;
        }

        public String getTDSandCheck(TDS tds) {
            if (this.LaValue instanceof IDF) {
                TDS declarredtds=tds;

                if (!tds.VerifDeclarationPortee(((IDF) this.LaValue).name)) {


                    if (tds.getPere() != null) {
                        TDS previoustds = tds.getPere();
                        while (!previoustds.VerifDeclarationPortee(((IDF) this.LaValue).name)) {
                            if (previoustds.getPere() == null) {
                                ErrorFlag.raiseError();
                                System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) this.LaValue).name + " n'est pas déclarée");
                                return "void";
                            }
                            else {
                                previoustds = previoustds.getPere();
                            }
                        }
                        declarredtds=previoustds;

                    }
                    else {
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne " + this.line + " : la variable " + ((IDF) this.LaValue).name + " n'est pas déclarée");
                        return "void";
                    }

                    String typelavalue = declarredtds.getInstances(((IDF) this.LaValue).name).getType();
                    String typeexpr = this.ouexpression.getTDSandCheck(tds);
                    if (!typelavalue.equals(typeexpr)) {
                        ErrorFlag.raiseError();
                        System.out.println("Erreur ligne " + this.line + " : la variable de gauche est de type " + typelavalue);
                    }
                }
            }

            else {
                String typelvalue = LaValue.getTDSandCheck(tds);
                String typeexpr = ouexpression.getTDSandCheck(tds);
                if (!typelvalue.equals(typeexpr)) {
                    ErrorFlag.raiseError();
                    System.out.println("Erreur ligne " + this.line + " : la variable de gauche est de type " + typelvalue);
                }
            }

            return "void";
        }
    }
