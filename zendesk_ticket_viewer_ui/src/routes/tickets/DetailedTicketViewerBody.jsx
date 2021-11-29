import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";
import * as Utils from "../../utils/Utils";

export default function DetailedTicketViewerBody(detailedTicketViewerBodyProps) {

    React.useEffect(() => {

    if (Utils.isNonNull(detailedTicketViewerBodyProps.activeTicket)) {
        const activeTicket = detailedTicketViewerBodyProps.activeTicket.split("-")[1];
                if (parseInt(activeTicket) === detailedTicketViewerBodyProps.ticketId) {
                    console.log("-----------Execute fetch--------------");
                }


    }



    }, [detailedTicketViewerBodyProps.ticketId, detailedTicketViewerBodyProps.activeTicket]);


   return (
   <div className={"container-fluid"}>

   </div>);



}