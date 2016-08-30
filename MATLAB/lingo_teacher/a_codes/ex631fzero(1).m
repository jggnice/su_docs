% 大学数学实验2 p.124 fzero例  % 解  p.118   图形法 中的方程
% 大学数学实验  p.123 fzero例  % 解  p.116   图形法 中的方程
% 解在 -1.75, -0.75, 1.00, 2.40 附近
f = inline('x^6 - 2*x^4 - 6*x^3 - 13*x^2 + 8*x + 12')
ezplot( f, [-2, 2.5]),grid		%作图

x1 = fzero(f, -1.75);
x2 = fzero(f, -0.75);
x3 = fzero(f,  1.00);
x4 =fzero(f,  2.40);
x = [x1;x2;x3;x4];

x1a = fzero(f, [-2, -1.5]);
x2a = fzero(f, [-1, -0.5]);
x3a = fzero(f, [0.5,1.5]);
x4a = fzero(f, [  2, 2.5]);
xa = [x1a;x2a;x3a;x4a];

format long
[x,xa]
format

[ x, fv, ev, out ] = fzero(f, 2)

[ x, fv, ev, out, jac] = fsolve(f, 2)

% 结果：
%f =
%     Inline function:
%    f(x) = x^6 - 2*x^4 - 6*x^3 - 13*x^2 + 8*x + 12
%
%ans =
%  -1.74453992789401  -1.74453992789401
%  -0.78943412979625  -0.78943412979625
%   1.00000000000000   1.00000000000000
%   2.40883368438696   2.40883368438696
%
%x =     2.4088
%fv =  1.7764e-014	% fv是x点对应的函数值
%ev =     1		% 正数1表示找到异号点，负数-1表示没有找到异号点
%out = 	
%     iterations: 23	%迭代了23次
%     funcCount: 23	%函数被调用了23次
%     algorithm: 'bisection, interpolation'	%算法是二分法和插值法
%
% Optimization terminated successfully:
% First-order optimality is less than options.TolFun.
%x =    2.4088
%fv =  2.0961e-013
%ev =     1
%out = 
%       iterations: 8	%迭代了23次
%       funcCount: 15	%函数被调用了23次
%       algorithm: 'trust-region dogleg'	%算法是置信域折线形曲线
%    firstorderopt: 4.5218e-011		% x点处梯度向量的1-范数
%jac =   215.7229	%x点处对应的雅可比矩阵

