% 大学数学实验  p.156~160  例7.05      p.160|167 用最小二乘法+分析导数(雅可比矩阵)
% 求解 min 100 ( x2 - x1^2 )^2 + ( 1 - x1 )^2  
% 初值 [ -1.9, 1] 

x0 = [ -1.9, 2 ];

opt1 = optimset('LargeScale', 'off', 'MaxFunEvals', 1000, 'Jacobian', 'on');
[x1, norm1, res1, exit1, out1] = lsqnonlin('ex746_5flj', x0, [], [], opt1)
opt2 = optimset(opt1, 'LevenbergMarquardt', 'off');
[x2,  norm1, res1, exit2, out2] = lsqnonlin('ex746_5flj', x0, [], [], opt2)

