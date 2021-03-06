function [ c, ceq, g, geq] = ex0804con(x)	%编写非线性约束的M文件 
% 大学数学实验2 p.209  实验9 例2  求解非线性规划 
% 大学数学实验  p.185  实验8 例4  求解非线性规划
% min z = e^x1( 4x1^2 + 2x2^2 + 4x1x2 + 2x2 + 1 )  
% s.t.  x1x2 – x1 – x2 + 1.5 <= 0,  x1x2 + 10 >= 0  
%        x1^2 + x2 – 1 = 0

c = [ x(1)*x(2) - x(1) - x(2) + 1.5 , - x(1)*x(2) - 10 ];	% 不等式约束
ceq = x(1)^2 + x(2) - 1;			% 等式约束
if  nargout  >  2
    g = [ x(2) - 1, -x(2); x(1) - 1, -x(1) ];
    geq = [ 2*x(1); 1 ];
end
