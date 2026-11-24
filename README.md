<p align="center">
  <img src=".github/banner.svg" alt="RPN Stacker" width="100%" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Compiladores-RPN%20%2F%20AST-EA580C?style=flat-square" alt="Compiladores" />
</p>

## Sobre o Projeto

Implementação incremental em **Java** de um avaliador e interpretador de expressões em **Notação Polonesa Reversa (RPN / Postfix)**, desenvolvido para a disciplina de **Compiladores**. O repositório mostra a evolução arquitetural em três etapas — de uma pilha ad-hoc simples até um pipeline completo com análise léxica, árvore sintática abstrata (AST) e interpretador.

## Evolução das Etapas

| Etapa | Pasta | O que implementa |
| :---: | :--- | :--- |
| **Task 01** | `[Task 01 - RPNStacker Adhoc][Aula 08 - 2910]/` | Avaliador direto com `Stack<Integer>` lendo expressões do arquivo `Calc1.stk` (`+`, `-`, `*`, `/`). |
| **Task 02** | `[Task 02 - RPNStacker ManualSimple Scanning]/` | Separação da etapa de **análise léxica manual** (`Token` e `TokenType`: `NUM`, `PLUS`, `MINUS`, `STAR`, `SLASH`, `EOF`) com tratamento de caracteres inválidos. |
| **Task 03** | `[Task 03 - RPNStackerPostfix][ID expression]/Postfix/` | Arquitetura modular completa: **Lexer** (`Scanner`, `Regex`, `LexError`), **Parser** (`Parser`, `ParserError`), **AST** (`Expr`, `AstPrinter`, padrão *Visitor* com `Binop`, `Number` e `Id`) e **Interpreter** (`Interpreter`, `InterpreterError`). |

## Como Executar

### Task 01 ou Task 02

```bash
cd "[Task 02 - RPNStacker ManualSimple Scanning]"
javac *.java
java Main
```

### Task 03 (Pipeline Completo)

```bash
cd "[Task 03 - RPNStackerPostfix][ID expression]/Postfix"
javac -d bin src/postfix/*.java src/postfix/ast/*.java src/postfix/lexer/*.java src/postfix/parser/*.java src/postfix/interpreter/*.java
java -cp bin postfix.Postfix
```

---

<div align="center">
  <sub>Desenvolvido por <a href="https://github.com/charles-gabriel-cc">Charles Gabriel</a></sub>
</div>
