def pow(x: Int, n: Int): Double = {
  if (n==0)
    1
  else if (n < 0)
    1 / pow(x, -n)
  else if (n % 2 == 0)
    pow(x, n / 2) * pow(x, n /2)
  else
    x.toLong * pow(x, n-1)
}

pow(2, 1000)