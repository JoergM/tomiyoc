function OptionsListCtrl($scope, $http) {
  $http({ method: 'GET', url: '/optionslist' }).
      success(function (data, status, headers, config) {
                $scope.options = data;
              });

  /* $scope.options = [
   {"id" : "1", "description": "Projekt 1 ist ein ganz tolles Projekt"},
   {"id" : "2", "description": "Projekt 2"},
   {"id" : "3", "description": "Projekt 3"},
   {"id" : "4", "description": "Projekt 4"},
   {"id" : "5", "description": "Projekt 5"},
   {"id" : "6", "description": "Projekt 6"},
   {"id" : "7", "description": "Projekt 7"},
   {"id" : "8", "description": "Projekt 8"}]*/
}

function saveVote(id, rfid) {
  console.log("vote: " + id + " rfid: " + rfid);
  $.ajax({
           url: '/savevote?option=' + id + '&karte=' + rfid,
           type: 'PUT',
           success: function (response) {
             console.log("vote: " + id + " rfid: " + rfid + " success");
             $('#top-layer').show();
           }
         });
}