def product(word: String): Long = {
  if (word.length==0)
    1
  else
    word.head.toLong * product(word.tail)
}

product("Hello")