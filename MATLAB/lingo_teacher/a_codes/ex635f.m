function f = azeofun(XT,n,P,a,b,c,Q) 
% 大学数学实验  p.115-116,127-127  例2  均相共沸混合物的组分  
x(n) = 1;
for i = 1:n-1
    x(i) = XT(i);
    x(n) = x(n)-x(i);
end
T = XT(n);
p = log(P);
for i = 1:n
    d(i) = x * Q(i, 1:n)';
    dd(i) = x(i)/d(i);
end
for i = 1:n
    f(i) = x(i)*(b(i)/(T+c(i)) + log(x*Q(i,1:n)')  + dd*Q(1:n,i) - a(i) - 1 + p);
end
