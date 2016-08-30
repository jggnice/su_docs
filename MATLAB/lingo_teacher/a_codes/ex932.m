% ��ѧ��ѧʵ��2 p.209  ʵ��9 ��2  �������Թ滮 
% ��ѧ��ѧʵ��  p.185  ʵ��8 ��4  �������Թ滮  ***** 6.5�治������******
% min z = e^x1( 4x1^2 + 2x2^2 + 4x1x2 + 2x2 + 1 )  
% s.t.  x1x2 �C x1 �C x2 + 1.5 <= 0,  x1x2 + 10 >= 0  
%        x1^2 + x2 �C 1 = 0

x0 = [ 1, -1 ];	% [ -1, 1 ]	% ��ʼ��

opt1 = optimset('largescale', 'off', 'MaxIter', 3000, 'Maxfun', 20000);	% �����еȹ�ģ�㷨ģʽ
% (�������з����Ե�ʽ�Ͳ���ʽԼ�������ģ�㷨������), �����������������ͺ���������
[ x, fv, ef, output, lamda, grad, hess  ] = fmincon( @ex932f, x0, [],[],[],[],[],[], @ex932con, opt1 )
[c1, c2] = ex932con(x)	
pause

opt2 = optimset(opt1, 'GradObj', 'on', 'GradCon', 'on', 'DerivativeCheck', 'on');
% ���÷����ݶȣ��ȽϷ����ݶ�����ֵ�ݶȵĲ���(�������֤�����ݶȵ������Ƿ���ȷ)
[ x, fv, ef, output, lamda, grad, hess ] = fmincon( @ex932f, x0, [],[],[],[],[],[], @ex932con, opt2 )
[c1, c2] = ex932con(x)	

% �������  ****2008��*********
%��ֵ  [ 1, -1 ];  &&&&&&&&&&&&&&&&&&&&&&&&&
%Warning: Options LargeScale = 'off' and Algorithm = 'trust-region-reflective' conflict.
%Ignoring Algorithm and running active-set method. To run trust-region-reflective, set
%LargeScale = 'on'. To run active-set without this warning, use Algorithm = 'active-set'.
%> In fmincon at 395
%  In ex0804 at 10
%Optimization terminated: magnitude of directional derivative in search
% direction less than 2*options.TolFun and maximum constraint violation
%  is less than options.TolCon.
%No active inequalities.
%x =    1.3584   -0.8452
%fv =   13.7185
%ef =     5
%output = 
%         iterations: 5
%          funcCount: 21
%       lssteplength: 0.5000
%           stepsize: 0.0018
%          algorithm: 'medium-scale: SQP, Quasi-Newton, line-search'
%      firstorderopt: 0.0034
%    constrviolation: 7.6000e-007
%            message: [1x172 char]
%lamda = 
%         lower: [2x1 double]
%         upper: [2x1 double]
%         eqlin: [0x1 double]
%      eqnonlin: -15.7680
%       ineqlin: [0x1 double]
%    ineqnonlin: [2x1 double]
%grad =
%   42.8394
%   15.7646
%hess =
%   39.5708   19.5366
%   19.5366   11.2403
%c1 =   -0.1613   -8.8519
%c2 =  7.6000e-007
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Warning: Options LargeScale = 'off' and Algorithm = 'trust-region-reflective' conflict.
%Ignoring Algorithm and running active-set method. To run trust-region-reflective, set
%LargeScale = 'on'. To run active-set without this warning, use Algorithm = 'active-set'.
%> In fmincon at 395
%  In ex0804 at 16
%Function derivative
%Maximum discrepancy between derivatives  = 3.32316e-007
%Constraint derivative
%Maximum discrepancy between derivatives  = 1.49012e-008
%Optimization terminated: magnitude of directional derivative in search
% direction less than 2*options.TolFun and maximum constraint violation
%  is less than options.TolCon.
%No active inequalities.
%x =    1.3584   -0.8452
%fv =   13.7185
%ef =     5
%output = 
%         iterations: 5
%          funcCount: 16
%       lssteplength: 0.5000
%           stepsize: 0.0018
%          algorithm: 'medium-scale: SQP, Quasi-Newton, line-search'
%      firstorderopt: 0.0034%
%    constrviolation: 7.5982e-007
%            message: [1x172 char]
%lamda = 
%         lower: [2x1 double]
%         upper: [2x1 double]
%         eqlin: [0x1 double]
%      eqnonlin: -15.7680
%       ineqlin: [0x1 double]
%    ineqnonlin: [2x1 double]
%grad =
%   42.8394
%   15.7646
%hess =
%   39.5721   19.5371
%   19.5371   11.2404
%c1 =   -0.1613   -8.8519
%c2 =  7.5982e-007

%��ֵ  [ 1, -1 ];  &&&&&&&&&&&&&&&&&&&&&&&&&���ֽ��
%Maximum number of iterations exceeded;       ----��������������
% increase OPTIONS.MaxIter.
%x =   -0.1562    1.2683
%fv =    5.1828
%ef =     0
%output = 
%         iterations: 3000
%          funcCount: 14268
%       lssteplength: 2
%           stepsize: 3.2266
%          algorithm: 'medium-scale: SQP, Quasi-Newton, line-search'
%      firstorderopt: 3.4514e+017
%    constrviolation: 0.2927
%            message: [1x65 char]
%lamda = 
%         lower: [2x1 double]         upper: [2x1 double]         eqlin: [0x1 double]
%      eqnonlin: 7.5593e+016       ineqlin: [0x1 double]    ineqnonlin: [2x1 double]
%grad =
%    8.4536
%    5.5160
%hess =
%  1.0e+018 *
%    0.1612   -0.6599
%   -0.6599    2.7012
%c1 =    0.1898   -9.8019
%c2 =    0.2927
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Function derivative
%Maximum discrepancy between derivatives  = 5.75141e-009
%Constraint derivative
%Maximum discrepancy between derivatives  = 0
%Maximum number of iterations exceeded;	----��������������
% increase OPTIONS.MaxIter.
%x =   -0.1220    1.2714
%fv =    5.5013
%ef =     0
%output = 
%         iterations: 3000
%          funcCount: 11438
%       lssteplength: 2
%           stepsize: 468.6668
%          algorithm: 'medium-scale: SQP, Quasi-Newton, line-search'
%      firstorderopt: 1.3225e+022
%    constrviolation: 0.2862
%            message: [1x65 char]
%lamda = 
%         lower: [2x1 double]         upper: [2x1 double]         eqlin: [0x1 double]
%      eqnonlin: -6.5550e+021       ineqlin: [0x1 double]    ineqnonlin: [2x1 double]
%grad =
%    9.1394
%    5.8402
%hess =
%  1.0e+018 *
%    0.0693   -0.5484
%   -0.5484    4.3377
%c1 =    0.1955   -9.8450
%c2 =    0.2862

