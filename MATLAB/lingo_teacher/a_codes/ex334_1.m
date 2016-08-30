% 大学数学实验2  p.59-61  教材例2  用几种公式在区间 [ 0, pi/4 ] 上计算 1/(1 - sin (x) )的积分，
% 精确值                   z = sqrt(2) = 1.41421356237310
% 辛普森公式               结果 z1 = 1.41421359288212,  z1 - z = 3.0509e-008
% Gauss-Lobatto公式结果 z2 = 1.41421367595081,  z2 - z = 1.1358e-007
% 
format long	% 以下结果显示为双精度格式
z = sqrt(2)
z1 = quad('1./(1 - sin(x))', 0, pi/4)  	%辛普森公式 
z1_z = z1 - z
z2 = quadl('1./(1 - sin(x))', 0, pi/4)	% Gauss-Lobatto公式
z2_z = z2 - z
format short