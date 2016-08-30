clear;
clc;
n= 6
A = hilb(n);
x = ones(n,1);

D = diag(diag(A));
B = D\(A-D);
b = A*x;
f = D\b;
x0 = zeros(n,1);
x1 = B*x0+f

while(max(abs(x0-x1))>0.001)
    x0 = x1;
    x1 = B*x0+f
end
