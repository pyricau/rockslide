/* Highlighter for Lisp */
SyntaxHighlighter.brushes.Lisp = function ()
{
    this.regexList = [
{ regex: SyntaxHighlighter.regexLib.doubleQuotedString, css: 'string' },
{ regex: /[()]/gmi, css: 'keyword bold' },
{ regex: /[(][^ ]*/gmi, css: 'keyword bold'},
{ regex: /[;](.*)/gmi, css: 'comments' }
                      ];
};
SyntaxHighlighter.brushes.Lisp.prototype = new SyntaxHighlighter.Highlighter ();
SyntaxHighlighter.brushes.Lisp.aliases = ['lisp', 'clisp', 'elisp', 'clojure', 'scheme'];