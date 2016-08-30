% ��ѧ��ѧʵ��2 p.207  ʵ��9 ��1  �����ι滮
% ��ѧ��ѧʵ��  p.183  ʵ��8 ��3  �����ι滮
% min z = 2x1^2 �C 3x1x2 + 3x2^3 �C 3x1 + x2  
% s.t.  x1 + 2x2 = 3 
%        2x1 �C x2 >=  �C 3 
%        x1 �C 3x2 <= 3
%        x1 >= 2,  x2 <= 0

H = [4  -3; -3  6]; c = [-3  1];
A1 = [-3  1; 1  -3];  b1 = [ 3  3];
A2 = [1  2];  b2 = 3;
v1 = [ 2  -inf ];  v2 = [inf  0]; 	% �¡��Ͻ�

[ x, fv, ef, output, lamda ] = quadprog( H, c, A1, b1, A2, b2, v1,v2 )
lamda_lower = lamda.lower
lamda_upper = lamda.upper
lamda_eqlin = lamda.eqlin
lamda_ineqlin = lamda.ineqlin

% �������
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
%lamda_upper =   [  0   26.0000]'	%Լ��  x2 <= 0 ����ЧԼ��
%lamda_eqlin =    -9			%Լ��  x1 + 2x2 = 3 ����ЧԼ��
%lamda_ineqlin =  [   0     0 ]'
