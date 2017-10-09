package tigase.idea.tdsl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import tigase.idea.tdsl.psi.TDSLTypes;
import com.intellij.psi.TokenType;
import static tigase.idea.tdsl.psi.TDSLTypes.*;

%%

%class TDSLLexer
%extends TDSLLexerBase
%unicode
%function advance
%type IElementType
%{
  @Override
  protected int getInitialState() {
    return YYINITIAL;
  }
%}

CRLF=\R
NEW_LINE=\n
WHITE_SPACE= [\ \t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
STRING=("'"[^"'"]*"'") | ("\""[^"\""]*"\"")
NUMBER=[0-9]+[dDfFlL]?
BOOLEAN="true" | "false"
END_OF_LINE_COMMENT="#"[^\r\n]*
ASSIGNMENT==
KEY=(\'.+\')|\w+
EXPRESSION_OPERATOR=("+"|"-"|"*"|"/")

BEAN_CFG_PROP_NAME="class" | "active" | "exportable"
BEAN_CFG_PROP_VALUE=[^:,\)\ ]+

ENV_PROP_FN_NAMES=("env"|"prop")

%state WAITING_VALUE
%state BEAN_CFG_PROPS
%state BEAN_CFG_PROPS_WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return TDSLTypes.COMMENT; }

<YYINITIAL> {
    "}" {
        yyendstate(YYINITIAL);
        return storeToken(RCURLY);
    }
}

"{"  {
    yybeginstate(YYINITIAL);
    return storeToken(LCURLY);
}

<YYINITIAL> "(" {
    yybeginstate(BEAN_CFG_PROPS);
    return storeToken(LPAREN);
}

<BEAN_CFG_PROPS> ")" {
    yyendstate(BEAN_CFG_PROPS);
    return storeToken(RPAREN);
}

<BEAN_CFG_PROPS> {BEAN_CFG_PROP_NAME} {
    yybegin(BEAN_CFG_PROPS_WAITING_VALUE);
    return storeToken(BEANCFGPROPNAME);
}
<BEAN_CFG_PROPS_WAITING_VALUE> {BOOLEAN} {
    yybegin(BEAN_CFG_PROPS);
    return storeToken(TDSLTypes.BOOLEAN);
}
<BEAN_CFG_PROPS_WAITING_VALUE> {BEAN_CFG_PROP_VALUE} {
    yybegin(BEAN_CFG_PROPS);
    return storeToken(BEANCFGPROPVALUE);
}
//<BEAN_CFG_PROPS> {WHITE_SPACE}* {
//    return TokenType.BAD_CHARACTER;
//}
<YYINITIAL> {WHITE_SPACE} {
    return TokenType.WHITE_SPACE;
}

<YYINITIAL> {KEY}({WHITE_SPACE})*"(" {
    yybegin(YYINITIAL);
    yypushback(1);
    while (yycharat(yylength()-1) == ' ' || yycharat(yylength()-1) == '\t' || yycharat(yylength()-1) == '\f') {
        yypushback(1);
    }
    return TDSLTypes.BEANNAME;
}

<YYINITIAL> {KEY}({WHITE_SPACE})*"{" {
    yybegin(YYINITIAL);
    yypushback(1);
    while (yycharat(yylength()-1) == ' ' || yycharat(yylength()-1) == '\t' || yycharat(yylength()-1) == '\f') {
        yypushback(1);
    }
    return TDSLTypes.BEANNAME;
}

<YYINITIAL> {KEY}({WHITE_SPACE})*"=" {
    yybegin(YYINITIAL);
    yypushback(1);
    while (yycharat(yylength()-1) == ' ' || yycharat(yylength()-1) == '\t' || yycharat(yylength()-1) == '\f') {
        yypushback(1);
    }
    return TDSLTypes.PROPNAME;
}

<YYINITIAL> {ASSIGNMENT}                                     { yybegin(WAITING_VALUE); return TDSLTypes.ASSIGNMENT; }

//<WAITING_VALUE> {NUMBER}+{EXPRESSION_OPERATOR}{NUMBER}+     { return TDSLTypes.EXPRESSION; }

<WAITING_VALUE> "+"                       { return TDSLTypes.OPERATORADD; }
<WAITING_VALUE> "-"                       { return TDSLTypes.OPERATORSUBSTRACT; }
<WAITING_VALUE> "*"                       { return TDSLTypes.OPERATORMULTIPLY; }
<WAITING_VALUE> "/"                       { return TDSLTypes.OPERATORDIVIDE; }
<WAITING_VALUE> "[" {
    return storeToken(TDSLTypes.LBRACK);
}
<WAITING_VALUE> "]" {
    return storeToken(TDSLTypes.RBRACK);
}
<WAITING_VALUE> {ENV_PROP_FN_NAMES} {
    return TDSLTypes.ENVPROPFNNAME;
}
<WAITING_VALUE> "(" {
    return storeToken(TDSLTypes.LPAREN);
}
<WAITING_VALUE> ")" {
    return storeToken(TDSLTypes.RPAREN);
}

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               {
    if (!isWithinBraces()) {
        yybegin(YYINITIAL);
    }
    return TokenType.WHITE_SPACE;
}

<WAITING_VALUE> {WHITE_SPACE}+                              { return TokenType.WHITE_SPACE; }

{NEW_LINE} {
    if (!isWithinBraces()) {
        yybegin(YYINITIAL);
    }
    return TokenType.WHITE_SPACE;
}

<WAITING_VALUE> {STRING}*                                   { return TDSLTypes.STRING; }

<WAITING_VALUE> {NUMBER}*                                   { return TDSLTypes.NUMBER; }

<WAITING_VALUE> {BOOLEAN}*                                  { return TDSLTypes.BOOLEAN; }

"," {
    return TDSLTypes.COMMA;
}

":" {
    return TDSLTypes.COLON;
}


({CRLF}|{WHITE_SPACE})+                                     { return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }