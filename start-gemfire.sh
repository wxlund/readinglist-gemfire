echo "Starting GemFire Distributed System"

gfsh start locator --name=locator1
gfsh -e "connect" -e "configure pdx --read-serialized=true" -e "start server --name=server1"
gfsh -e "connect" -e "create region --name=Book --type=REPLICATE" 


