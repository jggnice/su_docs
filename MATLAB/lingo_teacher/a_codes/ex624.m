% 大学数学实验2 p.122 例2  求解非线性方程组
% 大学数学实验  p.121 例2  求解非线性方程组
%(1) 用p.121|122 牛顿迭代公式 (28) 求解方程组
%(2) 用p.124|125 fsolve 函数 求解方程组
%(3) 用p.435|429 solve  函数 求解方程组
% 迭代求解 F(x) = {x1^2 + x2^2 = 4, x1^2 - x2^2 = 1}， 初值(1,1)'
%                   F'(x) = 2{x1  x2; x1,  -x2}
x0 = 1; y0 = 1; n = 10; tol = 1e-6;	% 初值
x(1) = x0; y(1) = y0;
i = 1; u = [1  1]; k(1) = 0;
while ( norm(u) > tol*norm([x(i), y(i)]') )
    A = 2*[x(i), y(i); x(i), -y(i)];			% A = F'(x(k))
    b = [ 4 - x(i)^2 - y(i)^2,  1 - x(i)^2 + y(i)^2 ]';	% b = -F(x(k))
    u = A\b;
    x(i+1) = x(i) + u(1);
    y(i+1) = y(i) + u(2);
    k(i+1) = i;  i = i + 1;  
    if  (i>n)  error('n is full');
    end;
end
format long
[k', x', y']

%(2) 用p.124|125 fsolve 函数 求解方程组
x0 = [1 1];
[ x, fv, ev, out, jac] = fsolve(@ex624f, x0,[],1,4,-1,1)  

%(3) 用p.435|429 solve  函数 求解方程组    2008a不能执行 
syms x1 x2
[x1, x2] = solve('x1^2 + x2^2 = 4', 'x1^2 - x2^2 = 1');
x12 = [x1,x2]
x12v = double(x12)

format

% (1) 牛顿迭代法的结果
%ans =
%                  0   1.00000000000000   1.00000000000000
%   1.00000000000000   1.75000000000000   1.25000000000000
%   2.00000000000000   1.58928571428571   1.22500000000000
%   3.00000000000000   1.58115971107544   1.22474489795918
%   4.00000000000000   1.58113883022207   1.22474487139159
%   5.00000000000000   1.58113883008419   1.22474487139159
%
% (2) fsolve 的结果
% Optimization terminated successfully:
% First-order optimality is less than options.TolFun.
%x =   1.58113883008425   1.22474487169677
%fv =					% fv是x点对应的函数值
%  1.0e-009 *
%   0.74771744351665  -0.74735861943509
%ev =     1				% 1表示收敛, -1表示不收敛, 0表示达到迭代可函数调用上限
%out = 
%       iterations: 5				% 迭代了5次
%       funcCount: 15				% 函数被调用了23次
%       algorithm: 'trust-region dogleg'		% 算法是置信域折线形曲线
%    firstorderopt: 3.662173489061327e-009	% x点处梯度向量的1-范数
%jac =					% x点处对应的雅可比矩阵
%   3.16227769786555   2.44948974217282
%   3.16227769786555  -2.44948975433956
%
% (3) solve的结果
%x12 =
%[  1/2*10^(1/2),   1/2*6^(1/2)]
%[ -1/2*10^(1/2),   1/2*6^(1/2)]
%[  1/2*10^(1/2),  -1/2*6^(1/2)]
%[ -1/2*10^(1/2),  -1/2*6^(1/2)]
%x12v =
%   1.58113883008419   1.22474487139159
%  -1.58113883008419   1.22474487139159
%   1.58113883008419  -1.22474487139159
%  -1.58113883008419  -1.22474487139159


