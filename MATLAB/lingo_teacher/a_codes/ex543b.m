% 大学数学实验2 (p.29-30),91-92,106-107  实验5 例2  一年生植物的繁殖(续)
% 大学数学实验  (p.25-28),90,107-108     实验5 例2  一年生植物的繁殖(续)

% 用追赶法
p = -1; q = -0.05;
x0 = 100; xn = 1000; 
n = 49;
f = zeros(n,1);   f(1) = -q*x0;  f(n) = -xn;	% 输入方程的右端项
u(1) = p;  y(1) = f(1);			% 输入li, ui 的初值
for i = 2:n				% 递推计算方程组 (31) (32) 的 li ui yi
    L(i) = q/u(i-1);
    u(i) = p - L(i);
    y(i) = f(i) - L(i)*y(i-1);
end
x2 = zeros(1, n);
x2(n) = y(n)/u(n);
for i = n-1:-1:1			% 递推计算方程组 (32) 的 xi
    x2(i) = (y(i) - x2(i+1))/u(i);
end
x2

%xx = [full(x),x2']  			% 显示2个结果