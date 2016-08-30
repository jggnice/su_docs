% ��ѧ��ѧʵ��2 p.209  ʵ��9 ��2  �������Թ滮 
% ��ѧ��ѧʵ��  p.185  ʵ��8 ��4  �������Թ滮  
% min z = e^x1( 4x1^2 + 2x2^2 + 4x1x2 + 2x2 + 1 )  
% s.t.  x1x2 �C x1 �C x2 + 1.5 <= 0,  x1x2 + 10 >= 0  
%        x1^2 + x2 �C 1 = 0

x0 = [ 1, -1 ]	
%x0 = [ -1, 1 ]	% ��ʼ��

opt1 = optimset('largescale', 'off', 'MaxIter',3000, 'Maxfun', 20000);	% �����еȹ�ģ�㷨ģʽ
% (�������з����Ե�ʽ�Ͳ���ʽԼ�������ģ�㷨������), �����������������ͺ���������
[ x, fv, ef, output, lamda, grad, hess  ] = fmincon( @ex932f, x0, [],[],[],[],[],[], @ex932con, opt1 )
[c1, c2] = ex932con(x)	
pause

opt2 = optimset(opt1, 'GradObj', 'on', 'GradCon', 'on', 'DerivativeCheck', 'on');
% ���÷����ݶȣ��ȽϷ����ݶ�����ֵ�ݶȵĲ���(�������֤�����ݶȵ������Ƿ���ȷ)
[ x, fv, ef, output, lamda, grad, hess ] = fmincon( @ex932f, x0, [],[],[],[],[],[], @ex932con, opt2 )
[c1, c2] = ex932con(x)	

% �������  ****6.5��*********
%��ֵ  [ 1, -1 ];  &&&&&&&&&&&&&&&&&&&&&&&&&
%Optimization terminated successfully:
% Magnitude of directional derivative in search direction 
%  less than 2*options.TolFun and maximum constraint violation 
%  is less than options.TolCon
%Active Constraints:     1
%x =    1.3584   -0.8452
%fv =   13.7185
%ef =     1
%output = 
%       iterations: 5
%        funcCount: 26
%         stepsize: 0.5000
%        algorithm: [1x44 char]
%    firstorderopt: 0.0034
%     cgiterations: []
%lamda = 
%         lower: [2x1 double]         upper: [2x1 double]         eqlin: [0x1 double]
%      eqnonlin: -15.7680       ineqlin: [0x1 double]    ineqnonlin: [2x1 double]
%grad =   42.8393;   15.7646
%hess =   39.5828   19.5376
%               19.5376   11.2340
%c1 =   -0.1613   -8.8519
%c2 =  7.6307e-007
% ----------------------------------------------------------------------------------------------------------------
%Function derivative
%Maximum discrepancy between derivatives  = 2.55058e-007
%Constraint derivative
%Maximum discrepancy between derivatives  = 8.27404e-008
%Optimization terminated successfully:
% Magnitude of directional derivative in search direction 
%  less than 2*options.TolFun and maximum constraint violation 
%  is less than options.TolCon
%Active Constraints:     1
%x =    1.3584   -0.8452
%fv =   13.7185
%ef =     1
%output = 
%       iterations: 5
%        funcCount: 16
%         stepsize: 0.5000
%        algorithm: [1x44 char]
%    firstorderopt: 0.0034
%     cgiterations: []
%lamda = 
%         lower: [2x1 double]         upper: [2x1 double]         eqlin: [0x1 double]
%      eqnonlin: -15.7680       ineqlin: [0x1 double]    ineqnonlin: [2x1 double]
%grad =   42.8394;   15.7646
%hess =   39.5721   19.5371
%               19.5371   11.2404
%c1 =   -0.1613   -8.8519
%c2 =  7.5982e-007

%=============================================================
%��ֵ  [ -1, 1 ];  &&&&&&&&&&&&&&&&&&&&&&&&&
%Maximum number of iterations exceeded;
%increase OPTIONS.MaxIter
%x =   -0.1592    1.2773
%fv =    5.2068
%ef =     0
%output = 
%       iterations: 3001
%        funcCount: 15851
%         stepsize: 2
%        algorithm: [1x44 char]
%    firstorderopt: 3.0253e+017
%     cgiterations: []
%lamda = 
%         lower: [2x1 double]         upper: [2x1 double]         eqlin: [0x1 double]
%      eqnonlin: 2.4409e+016       ineqlin: [0x1 double]    ineqnonlin: [2x1 double]
%grad =    8.4777;    5.5196
%hess =  1.0e+018 *
%    0.1720   -0.7029
%   -0.7029    2.8724
%c1 =    0.1786   -9.7966
%c2 =    0.3026
%----------------------------------------------------------------------------------------------------
%Function derivative
%Maximum discrepancy between derivatives  = 6.29584e-009
%Constraint derivative
%Maximum discrepancy between derivatives  = 8.27404e-008
%Maximum number of iterations exceeded;
%increase OPTIONS.MaxIter
%x =   -0.1553    1.2664
%fv =    5.1796
%ef =     0
%output = 
%       iterations: 3001
%        funcCount: 10128
%         stepsize: 2
%        algorithm: [1x44 char]
%    firstorderopt: 1.5057e+017
%     cgiterations: []
%lamda = 
%         lower: [2x1 double]         upper: [2x1 double]         eqlin: [0x1 double]
%      eqnonlin: 4.4179e+016       ineqlin: [0x1 double]    ineqnonlin: [2x1 double]
%grad =    8.4527;    5.5173
%hess =  1.0e+018 *
%    0.0760   -0.3096
%   -0.3096    1.2617
%c1 =    0.1923   -9.8033
%c2 =    0.2905
