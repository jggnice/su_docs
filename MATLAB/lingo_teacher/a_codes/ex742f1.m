function y = ex0703f1(x, t)
% 大学数学实验|2  p.149|152  例3 
% 拟合c( t ) = r e(–k t) 中的系数 r,  k 
% r -- x(1),  k -- x(2)
% 初值 [ 10, 0.5 ] 
y = x(1) * exp( -x(2) * t ) ;
