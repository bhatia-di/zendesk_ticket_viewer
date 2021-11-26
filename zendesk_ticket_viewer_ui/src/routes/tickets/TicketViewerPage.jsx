import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";

export default function TicketViewerPage() {
  const [tickets, setTickets] = useState(null);
  React.useEffect(() => {
        fetch(APIURLS.getTicketsURL).then(response => response.json())
        .then(result => {
            console.log(result);
        });


  }, []);


  if (tickets) {
    return (
    <div className={"container-fluid"}>
      <h1><i class="fa fa-amazon"  />You are in TicketViewerPage Section</h1>
    </div>


    );

  } else {
   return(
       <div className={"container-fluid"}>
            <ReactLoading type={"spinningBubbles"} color={"#1f939c"} height={'20%'} width={'20%'} />
      </div>

      );

  }





}
