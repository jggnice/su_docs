function [h,p,ci,zval] = ztest2(x,y,sigma1,sigma2,alpha,tail)
%ZTEST2 Hypothesis test: Compares the averages of two samples.
%   [H,P,CI,STATS] = TTEST2(X,Y,ALPHA,TAIL) performs a z-test to
%   determine whether two samples from a normal distribution (with
%   known variances) could have the same mean.
%
%   The null hypothesis is: "means are equal".
%   For TAIL =  0  the alternative hypothesis is: "means are not equal."
%   For TAIL =  1, alternative: "mean of X is greater than mean of Y."
%   For TAIL = -1, alternative: "mean of X is less than mean of Y."
%   TAIL = 0 by default.
%
%   ALPHA is desired significance level (ALPHA = 0.05 by default). 
%   P is the p-value, or the probability of observing the given result
%     by chance given that the null hypothesis is true. Small values
%     of P cast doubt on the validity of the null hypothesis.
%   CI is a confidence interval for the true difference in means.
%   STATS is zstats 
%
%   H=0 => "Do not reject null hypothesis at significance level of alpha."
%   H=1 => "Reject null hypothesis at significance level of alpha."

%   王振羽 2011-6-10 参照 ttest2, ztest, 数学实验p.277|290:ztest2 

if nargin < 4, 
    error('Requires at least four input arguments'); 
end

[m1 n1] = size(x);
[m2 n2] = size(y);
if (m1 ~= 1 & n1 ~= 1) | (m2 ~= 1 & n2 ~= 1)
    error('Requires vector first and second inputs.');
end
x = x(~isnan(x));
y = y(~isnan(y));
 
if nargin < 6, 
    tail = 0; 
end 

if nargin < 5, 
    alpha = 0.05; 
end 

if (prod(size(alpha))>1), error('ALPHA must be a scalar.'); end
if (alpha<=0 | alpha>=1), error('ALPHA must be between 0 and 1.'); end

n1 = length(x) ;
n2 = length(y) ;
xbar = mean(x);
ybar = mean(y);
difference = xbar - ybar;
ser = sqrt(sigma1^2/n1 + sigma2^2/n2);
zval = difference ./ ser;
p = normcdf(zval,0,1);

% the p-value just found is for the tail = -1 test
if (tail == 0)
    p = 2 * min(p, 1-p);
    if (nargout>2)
        crit = norminv(1 - alpha/2,0,1) .* ser;
        ci = [(difference  - crit) (difference + crit)];
    end
else
    if tail == 1
        p = 1 - p;
        if (nargout>2)
            crit = norminv(1 - alpha,0,1) .* ser;
            ci = [(difference - crit), Inf];
        end
    else
        if (nargout>2)
            crit = norminv(1 - alpha,0,1) .* ser;
            ci = [-Inf, (difference + crit)];
        end
    end
end



% Determine if the actual significance exceeds the desired significance
h = 0;
if p <= alpha, 
    h = 1; 
end 

if isnan(p), 
    h = NaN; 
end

