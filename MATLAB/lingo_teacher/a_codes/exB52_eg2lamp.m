clear all;
% 路灯问题
a=80; b=0.02; aoverb=a/b
mu=4000; s=100;
t=mu;                                       % 设定T的初值
step=0.1;                                    % T增加或减少的步长
var=0.01;                                   %（50）左右端比较的误差限
vp= mu*normcdf(t,mu,s)-s^2*normpdf(t,mu,s);   % 计算（50）左端
if vp>aoverb                                % （50）左端大于右端，T减少
    while (vp-aoverb)>var
      t=t-step;
      vp= mu*normcdf(t,mu,s)-s^2*normpdf(t,mu,s);
    end
end
if vp<aoverb                                 % （50）右端大于左端，T增加
    while (aoverb-vp)>var
      t=t+step;
      vp= mu*normcdf(t,mu,s)-s^2*normpdf(t,mu,s);
    end
end
vp,t 
