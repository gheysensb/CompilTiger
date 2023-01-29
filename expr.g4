grammar expr;

@header{
package parser;
}

program : expr EOF ;

expr : assignExpr;

lValue : IDF #affectidf
| lValue '[' expr ']' #affectsubscript
| lValue '.' IDF #affectfield
;

assignExpr: (lValue(':=' ouExpr)) #assign
| ouExpr #noassign;

ouExpr : etExpr ('|' etExpr)*;

etExpr : comparerExpr ('&' comparerExpr)*;

comparerExpr : plusmoinsExpr (('<'|'>'|'>='|'<='|'='|'<>') plusmoinsExpr) #compareexpr
| plusmoinsExpr #compare
;

plusmoinsExpr : muldivExpr (('+'|'-') muldivExpr)*;

muldivExpr : negExpr (('*'|'/') negExpr)*;

negExpr : ('-')* seqExpr;

seqExpr : otherExpr #noparenthese
| '(' (expr (';' expr)*)')' #parentheseexpr
| '('')' #parenthese
;

otherExpr : ifExpr #if
| whileExpr #while
| forExpr   #for
| letExpr   #let
| 'nil'     #nil
| 'break'   #break
| INT       #int
| STRINGS   #strings
| callExpr  #call
| arrCreate #arr
| lValue    #lvalue
| recCreate #rec ;

callExpr : IDF '(' (expr (',' expr)*) ')' #callexprexpr
| IDF '(' ')' #callexpr
;

arrCreate : IDF '[' expr ']' 'of' expr;

recCreate : IDF '{' (fieldCreate (',' fieldCreate)*) '}' #reccreatefield
|IDF '{' '}' #reccreate
;

fieldCreate : IDF '=' expr;

ifExpr : 'if' expr 'then' expr #ifthen
| 'if' expr 'then' expr 'else' expr #ifthenelse;

whileExpr : 'while' expr 'do' expr;

forExpr : 'for' IDF ':=' expr 'to' expr 'do' expr;

letExpr : 'let' (dec)+ 'in' (expr (';' expr)*) 'end' #letexprexpr
 |'let' (dec)+ 'in' 'end' #letexpr
 ;

dec : tyDec
| varDec
| funDec;

tyDec : 'type' IDF '='  IDF #tyidf
|'type' IDF '=' 'array' 'of' IDF #tyarr
| recTy #tyrec
;

recTy : 'type' IDF '=' '{' (fieldDec (',' fieldDec)*) '}' #rectyfield
|'type' IDF '=' '{' '}' #recty
;

fieldDec : IDF ':' IDF;

varDec : 'var' IDF ':=' expr #var
|'var' IDF ':' IDF ':=' expr #vartyid;

funDec : 'function' IDF '(' (fieldDec(',' fieldDec)*) ')' (':' IDF) '=' expr #funfieldtyid
|'function' IDF '(' (fieldDec(',' fieldDec)*) ')' '=' expr #funfield
|'function' IDF '(' ')' (':' IDF) '=' expr #funtyid
|'function' IDF '(' ')' '=' expr #fun
;







STRINGS :  '"'(~('\n'|'\t'| '"'))*'"' ;

IDF : (('A'..'Z')|('a'..'z')) ('_' | ('0'..'9') |('A'..'Z')|('a'..'z'))*;

INT : '0'|('1'..'9')(('0'..'9')*) ;

WS :('\n'|' '|'\t'|'\r'|'/*'.*?'*/'|'//'.*?('\r\n'|'\n')) -> skip;
COMMENT : ('/*'.*?'*/')->skip;
