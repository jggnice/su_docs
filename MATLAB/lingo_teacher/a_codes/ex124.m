% 大学数学实验第2版  p.14-14   例1.2.4  计算 pi
% 精确值     z = pi = 3.14159265358979323846

format long	% 以下结果显示为双精度格式

% 数值积分法
n = 10000;                % 100 1000 10000
h = 1/n;		% h = 1/n 		
x = 0 : h : 1;	
y = sqrt(1 - x.^2);
nn = length(y); 	% nn = n+1
z1 = 4 * (sum(y) - (y(1) + y(nn))/2 )* h	% 用梯形公式直接计算

% 迭代法1
n = 10;
a = 2*sqrt(3); b = 3;
for i = 1:n
   a = 2*a*b/(a+b);
   b = sqrt(a*b);
end
[a;b]

% 迭代法2
n = 10;
a = 1; b = 1/sqrt(2); s = 1/2;
cc = 1;
for i = 1:n
   aa = (a+b)/2;
   b = sqrt(a*b);
   a = aa;
   cc = 2*cc;
   s = s - cc*(a*a-b*b);
end
p = 2*a*a/s


% 无穷级数法1
n = 1000;
x = 1;  a = x; s = a; 
for i = 1:n
   a = -a*x*x;
   s = s + a/(2*i+1);
  % 4*s
end
s = 4*s


% 无穷级数法2
n = 10 - 1;
x1 = 1/2;  a1 = x1; s1 = a1; 
x2 = 1/3;  a2 = x2; s2 = a2; 
for i = 1:n
   a1 = -a1*x1*x1;
   s1 = s1 + a1/(2*i+1);
   a2 = -a2*x2*x2;
   s2 = s2 + a2/(2*i+1);
end
s = 4*(s1+s2)


% 无穷级数法3
n = 10 - 1;
x1 = 1/5;  a1 = x1; s1 = a1; 
x2 = 1/239;  a2 = x2; s2 = a2; 
for i = 1:n
   a1 = -a1*x1*x1;
   s1 = s1 + a1/(2*i+1);
   a2 = -a2*x2*x2;
   s2 = s2 + a2/(2*i+1);
end
s = 16*s1-4*+s2


% 随机模拟法
% 编程1--用矩阵函数
n = 100000;
x = rand(n,1);
y = rand(n,1);
z = x.*x+y.*y;
kk = find(z<1);
k = length(kk);
s = 4*k/n

% 编程2--用循环
n = 10000;
k = 0;
for i = 1:n
   x = rand(1,1);
   y = rand(1,1);
   if x.*x+y.*y < 1
      k = k + 1;
   end
end
s = 4*k/n


format short