% 大学数学实验|2  p.154|163  例7.4 (p.148例7.2)
% 求解 min(x^2/a +y^2/b), a = 10 b = 2 
% 初值 [ 1, 1] 
a = 10; b =1;
x0 = [1 1];
x = fminunc(@ex741_2f, x0, [], a, b)  %=例7.2
% 运行结果
%x =   1.0e-007 * (   0.0513   -0.1291  )

opt = optimset('fminunc');		%获取fminunc函数的缺省的控制参数值
opt = optimset(opt, 'Disp', 'iter');	%设置 输出中间结果
x = fminunc(@ex741_2f, x0, opt, a, b)
% 运行结果
%                                                        Directional 
%Iteration  Func-count     f(x)         Step-size      derivative 
%    1           2              1.1       0.544554          -4.04  
%    2           8        0.0809191       0.504496     -1.28e-008  
%    3          15     1.69215e-016        4.95545     -2.25e-009  
%
%Optimization terminated successfully:
% Search direction less than 2*options.TolX
%
%x =   1.0e-007 * (   0.0513   -0.1291  )

opt = optimset('fminunc');		%获取fminunc函数的缺省的控制参数值
opt = optimset(opt, 'tolx', 1e-16, 'tolf', 1e-16);	%设置 控制精度
[ x, fv, ef, out ] = fminunc(@ex741_2f, x0, opt, a, b)
% 运行结果
%x =  1.0e-008 * (    0.2521    0.0902  )
%fv =  1.4492e-018		%函数值
%ef =     1			% 1:收敛
%out = 
%       iterations: 4		%迭代次数
%       funcCount: 25		%目标函数调用次数
%       stepsize: 0.1415	%最后迭代步长
%       firstorderopt: 2.7468e-008  %一阶最优条件（梯度的范数）
%       algorithm: 'medium-scale: Quasi-Newton line search'	%所用算法：'中等规模:拟牛顿线性搜索'

