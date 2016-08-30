% 大学数学实验|2  p.148|151  例1 
% 求解 min(3sinx+x) 1<=x<=8 
x1 = 1; x2 = 8;		% 上下界
f = inline('3*sin(x) + x');		% 
[x, fv] = fminbnd(f, x1, x2)
% 运行结果
%x =    4.3726
%fv =   1.5441