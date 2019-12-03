var resultsNotFound={
    "errorCode":"0",
    "errorMessage":"Date server error"
};

module.exports={
    checkInputDataNull:function(req,res){
        if(!req.body) return res.send(resultsNotFound);
    },
    checkInputDataNull:function(req,res){
        resultsNotFound["errorMessage"]="there is no data from client";
        if(req.body.name=="")return res.send(resultsNotFound);
    }
}
