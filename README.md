###Lucene course exercises

##Exercise 1
As a search developer, I would like to implement a "Github like" file finder. Basically, I would like to have all subsequences of a document name to give a match, e.g.:

- lqdocsplgi => lucene/queryparser/docs/xml/img/plus.gif
- lqd///gif => lucene/queryparser/docs/xml/img/join.gif
- minusbottom.gif => lucene/queryparser/docs/xml/img/minusbottom.gif

##Exercise 2
As a search developer, I would like to implement proximity search in text files, i.e. for a given string S containing only words (sequences of lowercase English letters) and whitespaces and a non-negative integer number N, I'd like to match only those files that contain all words from S within overall edit distance no more than N.

##Exercise 3
As a search developer, I would like to extend org.apache.lucene.analysis.TokenFilter to have a filter that concatenates all tokens from a given token stream via a configured delimiter (" " by default). 


