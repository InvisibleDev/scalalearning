package chapter7

object Exercise9 extends App{
  var username = Console.readLine("Username: ")
  var password = Console.readLine("Password: ")
  if (password != "secret")
    Console.err.println("Wrong Password!")
  else
    Console.out.println(s"Hello $username!")
}