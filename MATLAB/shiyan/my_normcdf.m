n=1;
while((normcdf(41,40,5/sqrt(n))- normcdf(39,40,5/sqrt(n)))<0.95)
n=n+1;
end
n,