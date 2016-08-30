clear;
clc;
n=10;
A = hilb(n);
x = ones(n,1);
L = tril(A,-1)
U = triu(A,1)
D = diag(diag(A));
B = (D+L)\(-U);
b = A*x;
f = (D+L)\b;
x0 = zeros(n,1);
x1 = B*x0+f

while(max(abs(x0-x1))>0.0001)
    x0 = x1;
    x1 = B*x0+f
end
