clear all;
% ·������
a=80; b=0.02; aoverb=a/b
mu=4000; s=100;
t=mu;                                       % �趨T�ĳ�ֵ
step=0.1;                                    % T���ӻ���ٵĲ���
var=0.01;                                   %��50�����Ҷ˱Ƚϵ������
vp= mu*normcdf(t,mu,s)-s^2*normpdf(t,mu,s);   % ���㣨50�����
if vp>aoverb                                % ��50����˴����Ҷˣ�T����
    while (vp-aoverb)>var
      t=t-step;
      vp= mu*normcdf(t,mu,s)-s^2*normpdf(t,mu,s);
    end
end
if vp<aoverb                                 % ��50���Ҷ˴�����ˣ�T����
    while (aoverb-vp)>var
      t=t+step;
      vp= mu*normcdf(t,mu,s)-s^2*normpdf(t,mu,s);
    end
end
vp,t 
