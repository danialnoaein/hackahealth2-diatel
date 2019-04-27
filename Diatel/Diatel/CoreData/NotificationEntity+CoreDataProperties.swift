//
//  NotificationEntity+CoreDataProperties.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//
//

import Foundation
import CoreData


extension NotificationEntity {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<NotificationEntity> {
        return NSFetchRequest<NotificationEntity>(entityName: "NotificationEntity")
    }

    @NSManaged public var descript: String?
    @NSManaged public var id: String?
    @NSManaged public var name: String?
    @NSManaged public var patientname: String?
    @NSManaged public var time: NSDate?

}
