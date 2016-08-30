% 大学数学实验2 p.207  实验9 例1  求解二次规划
% 大学数学实验  p.183  实验8 例3  求解二次规划
% min z = 2x1^2 – 3x1x2 + 3x2^3 – 3x1 + x2  
% s.t.  x1 + 2x2 = 3 
%        2x1 – x2 >=  – 3 
%        x1 – 3x2 <= 3
%        x1 >= 2,  x2 <= 0

H = [4  -3; -3  6]; c = [-3  1];
A1 = [-3  1; 1  -3];  b1 = [ 3  3];
A2 = [1  2];  b2 = 3;
v1 = [ 2  -inf ];  v2 = [inf  0]; 	% 下、上界

[ x, fv, ef, output, lamda ] = quadprog( H, c, A1, b1, A2, b2, v1,v2 )
lamda_lower = lamda.lower
lamda_upper = lamda.upper
lamda_eqlin = lamda.eqlin
lamda_ineqlin = lamda.ineqlin

% 结果如下
%x =
%    3.0000
%    0.0000
%fv =    9.0000
%ef =     1
%output = 
%       iterations: 1
%        algorithm: 'medium-scale: active-set'
%    firstorderopt: []
%     cgiterations: []
%lamda = 
%      lower: [2x1 double]
%      upper: [2x1 double]
%      eqlin: -9		
%    ineqlin: [2x1 double]

%amda_lower =    [ 0     0 ]'
%lamda_upper =   [  0   26.0000]'	%约束  x2 <= 0 是有效约束
%lamda_eqlin =    -9			%约束  x1 + 2x2 = 3 是有效约束
%lamda_ineqlin =  [   0     0 ]'
