function yy = ex223f2(x0,n,b)	% 建立名为ex223f2的函数M文件，x0, n, b可调节
% 大学数学实验  p.25-27  2.2.1 例2   一年生植物的繁殖
% 大学数学实验2  p.29-30  2.2.4  一年生植物的繁殖
% 设一棵植物平均产种数为 c, 种子能够活过冬天的比例为 b, 
% 活过冬天的那些种子在来年春季发芽的比例为 a1，
% 未能发芽的那些种子又活过一个冬天的比例仍为 b, 在下
% 一年春季发芽的比例为 a2，
% 对初始数量x0, 种子能够活过冬天的比例b，返回n年后的数量
c = 10; a1 = 0.5; a2 = 0.25; 
p = -a1*b*c;
q = -a2*(1-a1)*c*b^2;
x1= -p*x0;
lamda1 = (-p+sqrt(p*p-4*q))/2;
lamda2 = (-p-sqrt(p*p-4*q))/2;      % 按p.29 (2.14) 式计算
C1 = (x1-lamda2*x0)/(lamda1 - lamda2);
C2 = (x1-lamda1*x0)/(lamda2 - lamda1);

for i = 0:(n-1)
  x(i+1) = C1*lamda1^i + C2*lamda2^i;	% 按p.30 (2.15) 式计算
end

yy = [lamda1,lamda2,C1,C2,x];