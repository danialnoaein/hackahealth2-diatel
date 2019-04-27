//
//  ReminderCell.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class ReminderCell: UITableViewCell {

    @IBOutlet weak var container: UIView!
    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var patientName: UILabel!
    @IBOutlet weak var time: UILabel!
    @IBOutlet weak var id: UILabel!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        container.clipsToBounds = true;
        container.layer.cornerRadius = 5
        title.layer.cornerRadius = 5
    }
    
}
