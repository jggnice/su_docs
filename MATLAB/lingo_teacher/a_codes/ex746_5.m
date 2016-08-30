% 大学数学实验  p.156~160  例7.05 
% 求解 min 100 ( x2 - x1^2 )^2 + ( 1 - x1 )^2  
% 初值 [ -1.9, 2] 
clear
fun = inline(' 100 * ( x(2) - x(1)^2 )^2 + ( 1 - x(1) )^2  ')

% 比较不同算法：不使用梯度(gradient)向量
format short e
x0 = [ -1.9, 2 ];
'----情况1: bfgs, hybrid 2, 3 poly(混合2,3次插值)-----------'
opt1 = optimset('LargeScale', 'off', 'MaxFunEvals', 1000);
%[x1, v1, exit1, out1] = fminunc(fun, x0, opt1)	%结果相同
[x1, v1, exit1, out1] = fminunc('ex746_5f', x0, opt1)
pause
'----情况2: dfp, hybrid 2, 3 poly(混合2,3次插值)-----------'
fopt = optimset(opt1, 'HessUpdate', 'dfp');
[x2, v2, exit2, out2] = fminunc('ex746_5f', x0, fopt)
pause
'----情况3: gillmurray, hybrid 2, 3 poly(混合2,3次插值)-----------'
fopt = optimset(opt1, 'HessUpdate', 'gillmurray');
[x3, v3, exit3, out3] = fminunc('ex746_5f', x0, fopt)
pause
'----情况4: steep, hybrid 2, 3 poly(混合2,3次插值)-----------'
fopt = optimset(opt1, 'HessUpdate', 'steepdesc');
[x4, v4, exit4, out4] = fminunc('ex746_5f', x0, fopt)
pause
'----情况5: bfgs, 3 poly (3次插值)-----------'
opt2 = optimset(opt1, 'LineSearchType', 'cubicpoly');
[x5, v5, exit5, out5] = fminunc('ex746_5f', x0, opt2)
pause
'----情况6: dfp, 3 poly (3次插值)-----------'
fopt = optimset(opt2, 'HessUpdate', 'dfp');
[x6, v6, exit6, out6] = fminunc('ex746_5f', x0, fopt)
pause
'----情况7: gillmurray, 3 poly (3次插值)-----------'
fopt = optimset(opt2, 'HessUpdate', 'gillmurray');
[x7, v7, exit7, out7] = fminunc('ex746_5f', x0, fopt)
pause
'----情况8: steep, 3 poly (3次插值)-----------'
fopt = optimset(opt2, 'HessUpdate', 'steepdesc');
[x8, v8, exit8, out8] = fminunc('ex746_5f', x0, fopt)
pause
'+ + + + 解的结果汇总 + + + + + +'
solutions = [x1; x2; x3; x4; x5; x6; x7; x8];
funvalues = [v1; v2; v3; v4; v5; v6; v7; v8];
iterations = [out1.funcCount; out2.funcCount; out3.funcCount; out4.funcCount; out5.funcCount; out6.funcCount; out7.funcCount; out8.funcCount];
aa = [solutions, funvalues, iterations]
