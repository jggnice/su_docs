% ��ѧ��ѧʵ��|2  p.178|186  ʵ��8 ��2  ������Թ滮
% min z = 3x1 + x2 - x3 
% s.t.  x1 + x2 �C 2 x3 >= 2   
%        x1 �C  2 x2 + x3 >= 2
%        3 x1 + 2 x2 - x3 = 14
%      x1, x2 , x3 >= 0
clear
format short

c = [3 1 -1]';
A1 = [1  1  -2; 1  -2  1];  A2 = [ 3  2  -1];
b1 = [2 2]';  b2 = 14;
v1 = [ 0 0 0 ]; 	% �½�

'*****p.178 ��linprog�������-  wrong A1, b1************'
[ x, f, exitflag, output, lamda ] = linprog( c, A1, b1, A2, b2, v1 )
% �������
%Exiting: One or more of the residuals, duality gap, or total relative error
%         has stalled:
%         the dual appears to be infeasible (and the primal unbounded).        ==>������⣬�޽�
%         (The primal residual < TolFun=1.00e-008.)  
%x =  1.0e+008 *
%    0.0000
%    1.9223
%    3.8445

'*****p.178 ��linprog�������-  right -A1, -b1************'
[ x, f, exitflag, output, lamda ] = linprog( c, -A1, -b1, A2, b2, v1 )
% �������
%Optimization terminated successfully.
%x =
%    4.0000
%    2.0000
%    2.0000
%f =   12.0000
%exitflag =     1
%output = 
%      iterations: 7
%    cgiterations: 0
%       algorithm: 'lipsol'
%lamda = 
%    ineqlin: [2x1 double]
%      eqlin: -0.7500
%      upper: [3x1 double]
%      lower: [3x1 double]


  