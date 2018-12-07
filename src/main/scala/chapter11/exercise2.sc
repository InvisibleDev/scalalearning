val a = 5
a
// ** wouldn't work since a.*(_needs_simple_type)
// ^ wouldn't work since according to precedence it is way after arithmetic operations, so
// 2 + 3 * 2^3 wouldn't result in 26 as per arithmetic precedence rules but will be 8^3, will confuse a lot.

