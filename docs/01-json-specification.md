# JSON的语法规定

A JSON text is a sequence of tokens formed from Unicode code points that conforms to the JSON value grammar.
The set of tokens includes six structural tokens, strings, numbers, and three literal name tokens.

The six structural tokens:
{}
[]
:
,

These are the three literal name tokens:
true 
false 
null

Insignificant whitespace is allowed before or after any token.
Whitespace is any sequence of one or more of the following code points: character tabulation (U+0009), line feed (U+000A), carriage return (U+000D), and space (U+0020).

A JSON value can be an object, array, number, string, true, false, or null.


## 备注:
json字符串指的就是文中的json value.
以前的spec中, json value只能是object/array,现在json value还支持number/string/true/false/null.


## 相关链接
https://stackoverflow.com/questions/18419428/what-is-the-minimum-valid-json