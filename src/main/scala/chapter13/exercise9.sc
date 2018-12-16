for (i <- 1 to 10; j <- 1 to i) yield i * j
(1 to 10).flatMap(i => (1 to i).map(j => i*j))
// flatMap is used to un-nest the list of lists
// (1 to i).map(j => i*j) is inner loop
// in case of 3
for (i <- 1 to 10; j <- 1 to i; k <- 1 to j) yield i * j * k
(1 to 10).flatMap(i => (1 to i).flatMap(j => (1 to j).map(k => i*j*k)))