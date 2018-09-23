def product(word: String)= {
  var unicodeMult = 1L
  for (ch <- word)
    unicodeMult *= ch.toInt
  unicodeMult
}

product("Hello")